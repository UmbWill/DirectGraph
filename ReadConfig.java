import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ReadConfig{
		private String _config_file_path = null;
		private String _config_graph_file = null; 

		ReadConfig(){}
		
		public boolean set_path_and_filename(String path,String filename){
			_config_file_path = path;
			_config_graph_file = filename;
			return true;
		}
		
		public boolean read_InterCommGraph(ArrayList<HashMap<String,String>> nodes, ArrayList<HashMap<String,String>> edges){
			XmlParser xmlPar = new XmlParser();
			if(!_set_load(xmlPar,_config_graph_file))return false;
			if(!xmlPar.get_SubNodesParamsList("Graph.nodes", nodes))return false;
			if(!xmlPar.get_SubNodesParamsList("Graph.edges", edges))return false;
			return true;
		}

		private boolean _set_load(XmlParser xmlPar, String file_name){
			Path currentpath = Paths.get(System.getProperty("user.dir"));
			
			Path actpro_file = null;
			if(_config_file_path == null){
				actpro_file = Paths.get(currentpath.toString(),file_name);
			}else{
				actpro_file = Paths.get(currentpath.toString(),_config_file_path,file_name);
			}
			System.out.println(actpro_file.toString());
			return xmlPar.load_file(actpro_file.toString());
		}
	}