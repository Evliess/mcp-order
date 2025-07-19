# This project for learning MCP

## How to Run

1. Run mvn install command to build the target jar file.
2. Put the jar file wherever you like
3. Update the ClientApp with correct jar path

```java
var stdioParams = ServerParameters.builder("java")
        .args("-jar", "C:\\Users\\xiaofei\\Desktop\\mcp\\mcp-order-1.0-SNAPSHOT.jar")
        .build();
```

4. Run the ClientApp then you will see the console log looks like:

```
11:00:01.846 [pool-1-thread-1] INFO io.modelcontextprotocol.client.McpAsyncClient -- Server response with Protocol: 2024-11-05, Capabilities: ServerCapabilities[completions=CompletionCapabilities[], experimental=null, logging=LoggingCapabilities[], prompts=PromptCapabilities[listChanged=true], resources=ResourceCapabilities[subscribe=false, listChanged=true], tools=ToolCapabilities[listChanged=true]], Info: Implementation[name=mcp-server, version=1.0.0] and Instructions null
TextContent[audience=null, priority=null, text="8=FIX.4.4|9=178|35=D|49=CLIENT123|56=BROKER456|34=5|52=20240719-10:30:45.123|11=ORD123456|15=USD|21=1|38=100|40=1|54=1|55=AAPL|59=0|60=20240719-10:30:45|10=123|"]
TextContent[audience=null, priority=null, text="8=FIX.4.4|9=167|35=F|49=CLIENT123|56=BROKER456|34=6|52=20240719-11:15:30.456|11=CANCEL12345|41=ORD123456|55=AAPL|54=1|60=20240719-11:15:30|10=234|"]
11:00:02.110 [parallel-8] WARN io.modelcontextprotocol.client.transport.StdioClientTransport -- Process terminated with code 1
```

## Tips

### Tip1: When you build an MCP server run within local stdio model, you must not print any log in the system console, so below configuration is required.

```yml
logging:
  pattern:
    console:
spring:
  main:
    banner-mode: off
```
