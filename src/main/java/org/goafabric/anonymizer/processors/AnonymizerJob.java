package org.goafabric.anonymizer.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnonymizerJob {
    @Autowired
    private PersonJob personJob;

    @Autowired
    private AddressJob addressJob;

    public void run() {
        personJob.run();
        addressJob.run();
    }
}
