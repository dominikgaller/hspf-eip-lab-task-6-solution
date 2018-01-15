package de.hspf.eip.task.solution;

import org.apache.camel.builder.RouteBuilder;

public class CountryRouter extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        from("file:/Users/dominikgaller/Documents/patternsLabCompany/input?noop=true")
                .choice()
                .when(xpath("order/country = 'DACH'"))
                .to("file:/Users/dominikgaller/Documents/patternsLabCompany/dach")
                .when(xpath("order/country = 'UK'"))
                .to("file:/Users/dominikgaller/Documents/patternsLabCompany/uk")
                .otherwise()
                .to("file:/Users/dominikgaller/Documents/patternsLabCompany/others");
    }
}
