# beans_mutability
Demo to show the mutability of spring beans with Singleton and Prototype scope

I focused on stateful beans, then used Singleton and Prototype scopes to show how the beans mutate their state. 

The class Job is extended by JobPrototype and JobSingleton beans which are loaded based on the active profile set. Tp set profile, set the property spring.profiles.active to either proto (for prototype scope) or singleton (for Singleton scope)

The active job beans are autowired inside Runner and Runner1 beans which have Scheduled methods to mutate state of the autowired bean periodically

  
