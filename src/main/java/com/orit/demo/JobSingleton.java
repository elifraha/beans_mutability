package com.orit.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("singleton")
public class JobSingleton extends Job {

}
