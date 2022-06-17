package org.goafabric.anonymizer;

import org.goafabric.anonymizer.processors.AddressJob;
import org.goafabric.anonymizer.processors.PersonJob;
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
        //todo: write processed jobs to a table and skip on next run, so that during a crash we won't start all over again
    }
}
