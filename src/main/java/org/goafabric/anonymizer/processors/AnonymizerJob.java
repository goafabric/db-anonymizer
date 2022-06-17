package org.goafabric.anonymizer.processors;

import org.goafabric.anonymizer.processors.PersonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnonymizerJob {
    @Autowired
    private PersonProcessor personProcessor;

    public void run() {
        personProcessor.run();
    }
}
