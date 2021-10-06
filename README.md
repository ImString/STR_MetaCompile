# STR_MetaCompile

## Demonstration
![Demonstracaoo](demo.png)

## Utilization
Just specify which files in the folder are server and which are client or shared.
Assuming these are these files:
```

   assets/
      images/
	     image.png
   server.lua (Type: Server)

   client.lua (Type: Client)

   config.lua (Type: Shared)
   
```

You would just put in the tab to fill in the files like this:

```
   config.lua-shared
   server.lua-server
   client.lua-client
```
