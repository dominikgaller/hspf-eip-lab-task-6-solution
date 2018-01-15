package de.hspf.eip.task.solution;

import de.hspf.eip.task.solution.configuration.Configuration;
import de.hspf.eip.task.solution.mapper.XmlFileReader;
import de.hspf.eip.task.solution.mapper.XmlMapper;
import de.hspf.eip.task.solution.model.Order;
import de.hspf.eip.task.solution.model.Position;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException {
        RouteBuilder countryRouter = new CountryRouter();
        RouteBuilder dachRegionRouter = new DACHRegionRouter();
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(countryRouter);
            camelContext.addRoutes(dachRegionRouter);
            camelContext.start();
            Thread.sleep(60 * 1000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        XmlFileReader xmlFileReader = new XmlFileReader();

        /* Moved from XmlFileReader */
        //Use the path here again, to tell your program where to find the file(s)
        String folderPath = Configuration.INPUT_FOLDER_PATH; //THIS IS A FOLDER NOW!

        //New code
        File inputFolder = new File(folderPath);

        //New loop for all files in the input folder
        for (File fileEntry : inputFolder.listFiles()) {
            //if the file IS NOT a directory
            if (!fileEntry.isDirectory() && 
                    fileEntry.getName().endsWith(".xml")) {
                /*
                    Run the code from edi mapper for each file 
                    (since edi mapper works well for files)
                 */
                ByteArrayInputStream byteArrayInputStream = xmlFileReader
                        .readXmlFile(fileEntry.getAbsolutePath());

                XmlMapper xmlMapper = new XmlMapper();
                Order order = xmlMapper.xmlOrderToJavaOrder(byteArrayInputStream);

                System.out.println(order.toString());

                List<Position> positions = order.getOrderbody();
                for (int i = 0; i < positions.size(); i++) {
                    Position position = positions.get(i);
                    System.out.println(position.toString());
                }
            }

        }
    }
}
