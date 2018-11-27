package com.orit.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Profile("proto")
@Scope("prototype")
public class JobPrototype extends Job {
}
