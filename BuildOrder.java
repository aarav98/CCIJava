Project[] findBuildOrder(String[] projects, String[][] dependencies){
    Graph graph = buildGraph(projects,dependencies);
    return orderProjects(graph.getNodes());
}

Graph buildGraph(String[] projects, String[][] dependencies){
    Graph graph = new Graph();
    for(String project : projects){
        graph.createNode(projects);
    }
    
    for(String[] dependency : dependencies){
        String first = dependency[0];
        String second = dependency[1];
        graph.addEdge(first,second);
    }
    return graph;
}

Project[] orderProjects(ArrayList<Projects> projects){
    Project[] order = new Project[project.size()];
    
    int endOfList = addNonDependent(order, projects, 0);
    int toBeProcessed = 0;
    while(toBeProcessed < order.length){
        Project current = order[toBeProcessed];
        if (current == null) return null;
        ArrayList<Project> children = current.getChildren();
        for(Project child: children){
            child.decrementDependencies();
        }
        endOfList = addNonDependent(order, children, endOfList);
        toBeProcessed++;
    }
    return order;
}

int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
    for(Project project : projects){
        if(project.getNumberOfDependencies() == 0){
            order[offset] = project;
            offset++;
        }
    }
    return offset;
}

public class Graph{
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<string, Project>();
    
    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        
        return map.get(name);
    }
    
    public void addEdge(String startname, String endname){
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbour(end);
    }
    
    public ArraList<Project> getNodes(){return nodes;}
}

public class Project{
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;
    
    public Project(String n){name = n;}
    
    public void addNeighbour(Project Node){
        if(!map.containsKey(node.getName())){
            children.add(node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies(){dependencies++;}
    public void decrementDependencies(){dependencies--;}
    
    public String getName(){return name;}
    public ArrayList<Project> getCgildren(){return children;}
    public int getNumberOfDependencies(){return dependencies;}
}