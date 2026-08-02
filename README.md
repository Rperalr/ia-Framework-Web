# Enterprise Automation AI

Independent Java library for orchestration agents, MCP tool abstractions, test planning/design/execution handlers and Jira/GitHub adapters.

## Dependency direction

```text
automation-ai -> automation-core
```

Core never depends on AI. The test repository consumes both artifacts.

## Maven coordinates

```xml
<dependency>
    <groupId>com.nttdata.enterprise.automation</groupId>
    <artifactId>automation-ai</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Build and publish

First publish or locally install Core `1.0.0`, then run:

```bash
mvn clean verify
mvn clean install
mvn clean deploy
```

The current agents are controlled simulations/facades. Jira, GitHub and model-provider network clients still require implementation and secret injection before production use.
