package de.hspf.eip.task.solution.mapper;


import de.hspf.eip.task.solution.model.Order;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaResult;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class XmlMapper {

    public Order xmlOrderToJavaOrder(ByteArrayInputStream xmlFileByteContent) throws IOException, SAXException {

        Smooks smooks = new Smooks("smooks-config.xml");
        ExecutionContext executionContext = smooks.createExecutionContext();
        JavaResult result = new JavaResult();
        smooks.filterSource(executionContext, new StreamSource(xmlFileByteContent), result);

        return (Order) result.getBean("order");
    }

}
