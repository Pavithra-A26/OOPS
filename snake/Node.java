public class Node{
    private int row =0;
    private int column=0;
    Node(int row,int column){
        this.row=row;
        this.column=column;
    }

    public int getcolumn(){
        return column;
    }

    public int getrow(){
        return row;
    }
}