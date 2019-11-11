import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DirectedGraph{

    private Map<Node, List<Node>> dirgraph = null;

    DirectedGraph(){
        dirgraph = new HashMap<Node, List<Node>>();
    }

    public void add_node(String id){
        dirgraph.putIfAbsent(new NodeBuilder().set_id(id).build(), new ArrayList<>());
    } 
    public void add_vnode(String id,String value){
        dirgraph.putIfAbsent(new NodeBuilder().set_id(id).set_value(value).build(), new ArrayList<>());
    } 
    public void add_tnode(String id,String type){
        dirgraph.putIfAbsent(new NodeBuilder().set_id(id).set_type(type).build(), new ArrayList<>());
    } 
    public void add_node(String id,String value,String type){
        dirgraph.putIfAbsent(new NodeBuilder().set_id(id).set_value(value).set_type(type).build(), new ArrayList<>());
    } 

    public void remove_node(String id){
        Node node = new NodeBuilder().set_id(id).build();
        dirgraph.values().stream().forEach(e->e.remove(node));
        dirgraph.remove(node);
    }
    /*public void remove_vnode(String id,String value){
        Node node = new NodeBuilder().set_id(id).set_value(value).build();
        dirgraph.values().stream().forEach(e->e.remove(node));
        dirgraph.remove(node);
    }
    public void remove_tnode(String id,String type){
        Node node = new NodeBuilder().set_id(id).set_type(type).build();
        dirgraph.values().stream().forEach(e->e.remove(node));
        dirgraph.remove(node);
    }
    public void remove_node(String id,String value,String type){
        Node node = new NodeBuilder().set_id(id).set_value(value).set_type(type).build();
        dirgraph.values().stream().forEach(e->e.remove(node));
        dirgraph.remove(node);
    }*/

    public void add_edge(String from_id, String to_id){
        Node n_from = null; // new NodeBuilder().set_id(from_id).build();
        Node n_to = null; //new NodeBuilder().set_id(to_id).build();
        Set<Node> kset = dirgraph.keySet();
        Iterator<Node> iter = kset.iterator();
        while(iter.hasNext()){
            Node n = iter.next();
            if(n.get_id().equals(from_id))n_from=n;
            if(n.get_id().equals(to_id))n_to=n;
            if(n_from!=null && n_to!=null){
                dirgraph.get(n_from).add(n_to);
                break;
            }
        }
        
    }

    public void remove_edge(String from_id, String to_id){
        Node n_from = new NodeBuilder().set_id(from_id).build();
        Node n_to = new NodeBuilder().set_id(to_id).build();
        dirgraph.get(n_from).remove(n_to);
    }

    /******* I don't see better idea in this moment
    this loop takes O(n^2) in the worst case 
    */
    public ArrayList<String> get_list_values(String from_value){
        ArrayList<String> list_values = new ArrayList<String>();
        Set<Node> kset = dirgraph.keySet();

        for(Node n : kset){
            if(n.get_value().equals(from_value)){
                for(Node ln : dirgraph.get(n)){
                    list_values.add(ln.get_value());
                }
            }
        }
        return list_values;
    }

    public ArrayList<String> get_list_types(String from_type){
        ArrayList<String> list_types = new ArrayList<String>();
        Set<Node> kset = dirgraph.keySet();
        for(Node n : kset){
            if(n.get_type().equals(from_type)){
                for(Node ln : dirgraph.get(n)){
                    list_types.add(ln.get_type());
                }
            }
        }
        return list_types;
    }

    // id could be more fast because there is just one id for every node. 
    // worst case O(2n) ~ O(n)
    public ArrayList<String> get_list_ids(String from_id){
        ArrayList<String> list_ids = new ArrayList<String>();
        Set<Node> kset = dirgraph.keySet();
        for(Node n : kset){
            if(n.get_id().equals(from_id)){
                for(Node ln : dirgraph.get(n)){
                    list_ids.add(ln.get_id());
                }
                break;
            }
        }
        return list_ids;
    }

    public Map<Node, List<Node>> get_dirgraph(){
        return dirgraph;
    }
    
}