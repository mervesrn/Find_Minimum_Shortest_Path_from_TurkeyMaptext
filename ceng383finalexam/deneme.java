package ceng383finalexam;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;





public class deneme {
	

	
	
	
	
	static class Graph{
		int Sourcevertex_;
        int vertices;
        int matrix[][];

      
        public void currentcity(int n) {
    		this.Sourcevertex_=n;
    
    		
    		
    	}
    	
    	
    	public void show_currentcity(){
    		
    		System.out.println("The current city's plate number : "+this.Sourcevertex_);
    		
    		
    	}
    	

    	
        
        public Graph(int vertex) {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }

        public void addEdge(int source, int destination, int weight) {
            //add edge
            matrix[source][destination]=weight;

            //add back edge for undirected graph
            matrix[destination][source] = weight;
        }

        //get the vertex with minimum distance which is not included in SPT
        int getMinimumVertex(boolean [] mst, int [] key){
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i <vertices ; i++) {
                if(mst[i]==false && minKey>=key[i]){
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        public void dijkstra_GetMinDistances(int sourceVertex){
            boolean[] spt = new boolean[vertices];
            int [] distance = new int[vertices];
            int INFINITY = Integer.MAX_VALUE;

            //Initialize all the distance to infinity
            for (int i = 0; i <vertices ; i++) {
                distance[i] = INFINITY;
            }

            //start from the vertex 0
            distance[sourceVertex] = 0;

            //create SPT
            for (int i = 0; i <vertices ; i++) {

                //get the vertex with the minimum distance
                int vertex_U = getMinimumVertex(spt, distance);

                //include this vertex in SPT
                spt[vertex_U] = true;

                //iterate through all the adjacent vertices of above vertex and update the keys
                for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) {
                    //check of the edge between vertex_U and vertex_V
                    if(matrix[vertex_U][vertex_V]>0){
                        //check if this vertex 'vertex_V' already in spt and
                        // if distance[vertex_V]!=Infinity

                        if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY){
                            //check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance

                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            if(newKey<distance[vertex_V])
                                distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            //print shortest path tree
            printDijkstra(sourceVertex, distance);
        }

        public void printDijkstra(int sourceVertex, int [] key){
            System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
            for (int i = 0; i <vertices ; i++) {
                System.out.println("Start city : " + sourceVertex + " to destination city " +   + i +
                        " distance: " + key[i]);
            }
        }
    }
	
public static void main(String[] args) throws IOException{
	
	
	//map to store a city id with city name as the key
			HashMap<String,Integer>citymap=new HashMap<>();//ınteger ile string yer değiştirmiş olabilir
			  LinkedList<String> mylinkedlist = new LinkedList<String>();
			  LinkedList<Integer> list_values = new LinkedList<Integer>();
			 
			  int[][] graph_matrix = new int[81][81];
			  
			  for (int row = 0; row <81; row++)
			  {
			  	for (int col = 0; col <81; col++)
			      {
			  		graph_matrix [row][col] = 0;
			  		//System.out.printf("%d",graph_matrix [row][col]);
			      }
			  	//System.out.println();
			  }
		
		//File input "input.txt"
		
		 BufferedReader br=new BufferedReader(new FileReader("/Users/mervesirin/Desktop/ceng383finalexam/input.txt"));
		
		String[] entry=br.readLine().split(";");
		
		for(int i=0;i<entry.length;i++)
		{
			Integer i_str=i;
			i_str.toString();
			System.out.println(entry[i]);
			citymap.put(entry[i],i+1);
			
		}
		
			
			
			BufferedReader br2=new BufferedReader(new FileReader("/Users/mervesirin/Desktop/ceng383finalexam/Distances.txt"));
			
			
			
			 String[] entry2=br2.readLine().split(";");
	System.out.println(entry2.length+"\n");
	

	
	int[][] twoIntegerArray = new int[81][81];	
			for(int i=0;i<81;i++)
			{ 
				for(int j=0;j<81;j++) {
					int point=83*(i)+2+j;
					int entry2_int=Integer.parseInt(entry2[point]);  
					//çektiğim stringleri integer value haline çevirdim 
					//böylece elimde 81x81 boyutunda integer matrix oluşturmuş oldum
					//bu matrix benim tüm şehirlerin birbirine olan uzaklıklarını içeriyor
					//EXCEL DOSYAMIN AYNISI 
					//bu yüzden düzenleme yapmam gerekiyor
					//bunun için ADJACENT CITIES DOSYAMI kullanacağım.
						twoIntegerArray [i][j]=entry2_int;
						System.out.printf("%s ",twoIntegerArray[i][j]);
						
					
					
					
				}
				
				System.out.println("****************************************\n");
				
			}
	
		
	
	

			
			try  
			{  
			File file=new File("/Users/mervesirin/Desktop/ceng383finalexam/adjacent_cities.txt");    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br4=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;  
			
			while((line=br4.readLine())!=null)  
			{  
				//line.split(",");
			//sb.append(line);  //appends line to string buffer 
			
			//sb.append("\n"); //line feed  
				 String[] entry3=line.split(",");
				    for(int i=0;i<entry3.length;i++) {
				    	
				    	mylinkedlist.add(entry3[i]);
				    	
				    }
				    
				    mylinkedlist.add("*\n");
			
			
			
			}  
			
			
			
			
			fr.close();    //closes the stream and release the resources  
			System.out.println("Contents of File: ");  
			   //returns a string that textually represents the object  
			System.out.println(mylinkedlist.get(0));
			
			for(int i=0;i< mylinkedlist.size();i++) {
				
				
				
				mylinkedlist.set(i, mylinkedlist.get(i).toLowerCase());//baş harfi büyük olduğunda eşit olmuyor
				mylinkedlist.set(i, mylinkedlist.get(i).replace('ı','i'));//türkçe karakter sıkıntısını giderdim
				if(citymap.containsKey(mylinkedlist.get(i))) {
				
				String value=citymap.get(mylinkedlist.get(i)).toString();
				mylinkedlist.set(i, value);
				}
				if(mylinkedlist.get(i).equals("*\n")) {
					
				
				}
				
				}
			
			
			int value_key = 0;
			int value_row=0;
			for(int i=1;i< mylinkedlist.size();i++) {
				
			if(i==1) {
				value_row=Integer.parseInt(mylinkedlist.getFirst())-1;
			}
					 
						if(!mylinkedlist.get(i).equals("*\n")) {
							value_key=Integer.parseInt(mylinkedlist.get(i))-1;
						}
						else{
							if(i==(mylinkedlist.size()-1)) {
								break;
							}
							else {
								value_row=Integer.parseInt(mylinkedlist.get(i+1))-1;
								value_key=Integer.parseInt(mylinkedlist.get(i+2))-1;
								i++;
							}
						}
						
					 graph_matrix[value_row][value_key]=1;
					
					}
					
					
				
	//Bu kısımda verilerin hepsine sahip olan tablom ile edge leri olan matrixi mi çarpıp 
			// adjacent matrix representation 
			
		
			 System.out.println();	
				
			 for (int row = 0; row <81; row++)
			  {
			  	for (int col = 0; col <81; col++)
			      {
			  	
			  		graph_matrix [row][col]=graph_matrix [row][col]*twoIntegerArray [row][col];
			  		System.out.printf(" %d ",graph_matrix [row][col]); 
			  		
			      }
			  System.out.println();
			  }
		
			
			
		
			System.out.println(mylinkedlist.toString());
			
			}  
			catch(IOException e)  
			{  
			e.printStackTrace();  
			} 
			
			
			int vertices = 81;
	       // Graph graph = new Graph(vertices);
			Graph graph = new Graph(81);
	        
	     
	    	int sayi=1;
	    	  String etc="";
	    	while(sayi==1){
	    		System.out.printf("\n\n%10s******************************************************************\n",etc);
	    		System.out.printf("%10s*%59s*\n",etc,etc);
	    		System.out.printf("%10s*----------------------------!! MENU !!----------------------------*\n",etc);
	    		System.out.println(""
	    				+ "ADANA    01	  EDİRNE22	 MALATYA44\n"
	    				+ "ADIYAMAN	02	ELAZIĞ 23	 MANİSA	45\n"
	    				+ "AKSARAY	68	ERZİNCAN24	 KAHRAMANMARAŞ46\n"
	    				+ "ARDAHAN	75	ERZURUM	25	 MARDİN	47\n"
	    				+ "AFYON	03	ESKİŞEHİR26	 MUĞLA	48\n"
	    				+ "AĞRI	   04	GAZİANTEP27	 MUŞ	49\n"
	    				+ "AMASYA	05	GİRESUN	28	 NEVŞEHİR50\n"
	    				+ "ANKARA	06	GÜMÜŞHANE29	 NİĞDE	51\n"
	    				+ "ANTALYA	07	HAKKARİ	30	 ORDU	52\n"
	    				+ "ARTVİN	08	HATAY	31	 OSMANİYE80\n"
	    				+ "AYDIN	09	IĞDIR	76	 RİZE	53\n"
	    				+ "BALIKESİR10	ISPARTA	32	 SAKARYA54\n"
	    				+ "BARTIN	74	İÇEL	33	 SAMSUN	55\n"
	    				+ "BATMAN	72	İSTANBUL34	 SİİRT	56\n"
	    				+ "BAYBURT	69	İZMİR	35	 SİNOP	57\n"
	    				+ "BİLECİK	11	KARABÜK	78	 SİVAS	58\n"
	    				+ "BİNGÖL	12	KARAMAN	70	 ŞIRNAK	73\n"
	    				+ "BİTLİS	13	KARS	36	 TEKİRDAĞ59\n"
	    				+ "BOLU	    14	KASTAMONU37	 TOKAT	60\n"
	    				+ "BURDUR	15	KAYSERİ	38	 TRABZON61\n"
	    				+ "BURSA	16	KIRIKKALE71	 TUNCELİ62\n"
	    				+ "ÇANAKKALE17	KIRKLARELİ39 ŞANLIURFA63\n"
	    				+ "ÇANKIRI	18	KIRŞEHİR40	 UŞAK   64\n"
	    				+ "ÇORUM	19	KİLİS	79	 VAN	65\n"
	    				+ "DENİZLİ	20	KOCAELİ	41	 YALOVA	77\n"
	    				+ "DİYARBAKIR21	KONYA   42	 YOZGAT	66\n"
	    				+ "DÜZCE	81	KÜTAHYA	43	 ZONGULDAK67\n"
	    			
	    		);
	    		
	    		
	    		
	    		
	    		
	    		
	    		System.out.println("Press 1: to enter the city plate number");
	    		System.out.println("Press 2: to show current city ");
	    		System.out.println("Press 3: to list k closest cities ");
	    		System.out.println("Press 4: to find shortest path to");
	    		System.out.println("Press 5: EXIT");
	    		System.out.printf(
	    			   "%10s******************************************************************\n",etc);
	    		System.out.println(":");
	    	
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	    	int choice= scanner.nextInt();
	    	
	    	
	    	
	    	int flag=1;
	    	while(flag==1){  
	    		
	    	   switch(choice){
	    	   
	    	   case 1:{
	    		   
	    		   Scanner sc=new Scanner(System.in);  
	    		   System.out.print("Enter the city plate number: ");  
	    		   int a= sc.nextInt();  
	    		   graph.Sourcevertex_=a;
	    		   
	    			break;
	    		  
	    		   }
	    	   	
	    	   case 2:
	    		 graph.show_currentcity();
	    		   break;
	    		   
	    	   case 3:
	    	   {
	    		   Scanner scannerr=new Scanner(System.in);  
	    		   System.out.print("Enter k closest city number : "); 
	    		   int k= scannerr.nextInt ( );
	    		   int count_k=0;
	    		   int remember=0;
	    		   
	    		 
	    		 for(int i=graph.Sourcevertex_;i<81;i++) {
	    		   for (int col = 0; (count_k<k && col<81); col++)
	 			      {
	 			  		if(graph_matrix [i][col]!=0) {
	 			  			System.out.println("k closest city distance :");
	 			  			System.out.println("one of closest city's plate number: ==> "+graph_matrix [i][col]);
	 			  			remember=col;
	 			  			count_k++;
	 			  		}
	 			  		
	 			  		if(col==80 && count_k<k) {
	 			  			i=remember;
	 			  			col=0;
	 			  		}
	 			  		

	 			      }

	 			  	
	 			  System.out.println();
	 			 
	    		 }
	    		   
	    		   
	    		   break;
	    		   }
	    	  
	    	   case 4:
	    	   {
	    		 
	    	
	    		   
	    		  // int vertices=graph.calculatevertex(sourceVertex, graph_matrix);
	    		
	    		   
	    		   
	    		   for (int row = graph.Sourcevertex_; row <81; row++)
	 			  {
	 			  	for (int col = graph.Sourcevertex_; col <81; col++)
	 			      {
	 			  		if(graph_matrix [row][col]!=0) {
	 			  			
	 			  			graph.addEdge(row,col,graph_matrix [row][col]);
	 			  			System.out.println(row+"----"+col+"----distance:"+graph_matrix [row][col]);
	 			  			
	 			  			
	 			  			
	 			  		}
	 			  		System.out.println("source vertex: "+graph.Sourcevertex_);
	 			       graph.dijkstra_GetMinDistances(graph.Sourcevertex_);
	 			       

	 			      }
	 			  	
	 			  System.out.println();
	 			  }
	    		   
	    		   
	    				 break;
	    			  }
	    		   
	    		 
	    	   case 5:
	    	   { 
	    		   flag=0;
	    		   System.exit(flag);
	    		   break;
    		   
	    		
	    		}
	    	  
	    	   
	    	   case 9:
	    		  
	    		   
	    	   default:
	    		   System.out.println("There is not found in MENU!!");
	    		   System.out.println("Invalid Option Entered. Please Enter Correct Option.");
	    		   break;
	    	
	                       }
	    	   break;
	                 }
	    	
	    	}
	        
					
			}		




	       
		
}





		
		
	

	
	
	
	
	
	
	
	


