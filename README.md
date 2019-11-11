# DirectGraph
A direct graph.

Nodes have 3 parameters:
* type 
* id
* value

Two nodes are equal if they have the same id.

Using NodeBuilder to create new Node with not all parameters. Of course, id is necessary!

Using XmlParser (see other repository) for read the xml configuration's file.

DirectGraph has the possibility to return 3 lists:
* *get_list_values* : the list of linked (exists an edge) nodes' values O(n^2)
* *get_list_types* : the list of linked (exists an edge) nodes' types O(n^2)
* *get_list_ids* : the list of linked (exists an edge) nodes' ids O(n)

## How to load and write the graph
Using an xml file to define the nodes and the edges.

Example:
```xml
<Graph>
	<nodes>
		<node type = "foofoo" id = "n0" value = "foofooval" />
		<node type = "booboo" id = "n1" value = "boobooval" />
		<node type = "looloo" id = "n2" value = "loolooval" />
	</nodes>
	<edges>
		<edge from = "n0" to = "n1"/>
		<edge from = "n1" to = "n0"/>		
		<edge from = "n2" to = "n0"/>	
		<edge from = "n1" to = "n2"/>	
	</edges>
</Graph>
```
