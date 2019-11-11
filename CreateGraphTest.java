import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.nio.file.Paths;
import java.nio.file.Path;

public class CreateGraphTest{
		

	public static void main(String[] args){
		ArrayList<HashMap<String,String>> nodes = new ArrayList<HashMap<String,String>>();
       ArrayList<HashMap<String,String>> edges = new ArrayList<HashMap<String,String>>();
	   ReadConfig readconf = new ReadConfig();
	   readconf.set_path_and_filename("","config_graph.xml");
	   readconf.read_InterCommGraph(nodes,edges);
       System.out.println(nodes);
       System.out.println(edges);
		DirectedGraph grtest = new DirectedGraph();
	   for(HashMap<String,String> param : nodes){
		   Iterator<Map.Entry<String,String>> iternp = param.entrySet().iterator();
		   String id=null;
		   String value=null;
		   String type=null;
		   while(iternp.hasNext()){
				Map.Entry<String,String> mapElem = iternp.next();
				if(mapElem.getKey().equals("id")){id=mapElem.getValue();}
				if(mapElem.getKey().equals("value")){value=mapElem.getValue();}
				if(mapElem.getKey().equals("type")){type=mapElem.getValue();}
		   }
		   grtest.add_node(id,value,type);
	   }

	   for(HashMap<String,String> param : edges){
			Iterator<Map.Entry<String,String>> iternp = param.entrySet().iterator();
			String from=null;
			String to=null;
			while(iternp.hasNext()){
				Map.Entry<String,String> mapElem = iternp.next();
				if(mapElem.getKey().equals("from")){from=mapElem.getValue();}
				if(mapElem.getKey().equals("to")){to=mapElem.getValue();}
			}
			grtest.add_edge(from,to);
		}
		System.out.println(grtest.get_dirgraph());
	}
}