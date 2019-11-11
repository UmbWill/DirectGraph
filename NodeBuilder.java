
public class NodeBuilder{
    private String _id = null;
    private String _value = null;
    private String _type = null;

    public NodeBuilder set_id(String id){
        this._id = id;
        return this;
    }
    public NodeBuilder set_value(String value){
        this._value = value;
        return this;
    }
    public NodeBuilder set_type(String type){
        this._type = type;
        return this;
    }

    public Node build(){
        return new Node(this._id,this._value,this._type);
    }
}