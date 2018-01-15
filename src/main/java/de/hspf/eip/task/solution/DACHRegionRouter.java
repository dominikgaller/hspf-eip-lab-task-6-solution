package de.hspf.eip.task.solution;

import org.apache.camel.builder.RouteBuilder;

public class DACHRegionRouter extends RouteBuilder {
  
    @Override
    public void configure() throws Exception {
        from("file:/Users/dominikgaller/Documents/patternsLabCompany/dach")
                .choice()
                .when(xpath("order/region = 'DE'"))
                .to("file:/Users/dominikgaller/Documents/patternsLabCompany/dach/de")
                .when(xpath("order/region = 'AT'"))
                .to("file:/Users/dominikgaller/Documents/patternsLabCompany/dach/at")
                .when(xpath("order/region = 'CH'")) //perfectly fine to stop here
                .to("file:/Users/dominikgaller/Documents/patternsLabCompany/dach/ch");
        
        //if you like to feel free to add an other folder for regions other than de/at/ch
        //and add an otherwise() choice accordingly.
    }
    
}
