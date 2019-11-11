public class Node{

    private String _id = null;
    private String _value = null;
    private String _type = null;

    Node(String id, String val, String type){
        this._id = id;
        this._value = val;
        this._type = type;
    }

    public String get_id(){
        return this._id;
    }

    public String get_value(){
        return this._value;
    }

    public String get_type(){
        return this._type;
    }

    public void set_id(String id){
        this._id = id;
    }

    public void set_value(String value){
        this._value = value;
    }

    public void set_type(String type){
        this._type = type;
    }
    
    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(obj == null) return false;
        if(!this.getClass().equals(obj.getClass())) return false;
        Node node = (Node) obj;
        return this._id.equals(node.get_id());//&&this._type.equals(node.get_type())&&this._value.equals(node.get_value());
        
    }

    @Override
    public int hashCode(){
        int hash = 1;
        hash = hash + this._id.hashCode();
        hash = hash + (this._value == null? 0 : this._value.hashCode());
        hash = hash + (this._type == null? 0 : this._type.hashCode());
        return hash;
    }


}