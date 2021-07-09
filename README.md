# Find_Minimum_Shortest_Path

![alt text](https://github.com/mervesrn/Find_Minimum_Shortest_Path_from_TurkeyMaptext/blob/main/Ekran%20Resmi%202021-07-09%2012.59.10.png)<br>
![alt text](https://github.com/mervesrn/Find_Minimum_Shortest_Path_from_TurkeyMaptext/blob/main/Ekran%20Resmi%202021-07-09%2012.59.32.png)<br>
![alt text](http://url/to/img.png)<br>

adjacent( x, y): tests whether there is an edge from the vertex x to the vertex y;<br>
    neighbors( x): lists all vertices y such that there is an edge from the vertex x to the vertex y;<br>
    add_vertex( x): adds the vertex x, if it is not there;<br>
    remove_vertex( x): removes the vertex x, if it is there;<br>
    add_edge( x, y): adds the edge from the vertex x to the vertex y, if it is not there;<br>
    remove_edge( x, y): removes the edge from the vertex x to the vertex y, if it is there;<br>
    get_vertex_value( x): returns the value associated with the vertex x;<br>
    set_vertex_value( x, v): sets the value associated with the vertex x to v.<br>
    int V() number of vertices<br>
    int E() number of edges<br>
     String toString() string representation<br>
    get_edge_value( x, y): returns the value associated with the edge (x, y);<br>
    set_edge_value( x, y, v): sets the value associated with the edge (x, y) to v.<br>
private <br>
int V; // number of vertices<br>
int E; // number of edges<br>
String []labesOfNodes;<br>
 adj; // adjacency lists (linked list matrix or hash table or whatever you consider more suitable<br>

