package org.goafabric.anonymizer.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnonymizerJob {
    @Autowired
    private PersonProcessor personProcessor;

    @Autowired
    private AddressProcessor addressProcessor;

    public void run() {
        personProcessor.run();
        addressProcessor.run();
    }
}
