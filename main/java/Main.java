
public static int[] vectorAdd(int x,int y,int dx, int dy) {
    x=x+dx;
    y=y+dy;
    return new int[] {x,y};
}


void main(String[] args) {
    int a=0;
    int b=2;
    int[] coordinates = vectorAdd(a,b,1,1);
    a = coordinates[0];
    b = coordinates[1];
    IO.println(a + "," + b);
}

