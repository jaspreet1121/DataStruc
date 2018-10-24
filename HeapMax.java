public class HeapMax {
    private int size = 8;
    private HeapNode[] h = new HeapNode[size];
    private int loca = 0;

    public void insert(int key, int value) {
        HeapNode temp = new HeapNode(key,value);
        if(loca < size) {
            h[loca] = temp;
            loca++;
        }else {
            size *= 2;
            HeapNode[] hp = new HeapNode[size];
            for(int i = 0;i<size/2;i++) {
                hp[i] = h[i];
            }
            h = hp;
            h[loca] = temp;
            loca++;
        }
        heapifyUp();
    }

    public void insert(int key) {
        insert(key,key);
    }

    public boolean isEmpty(){
        return loca==0;
    }

    public void heapifyUp() {
        int child = loca-1;
        int parent = (child-1)/2;
        while(parent>=0) {
            if(h[child].key>h[parent].key) {
                HeapNode a = h[child];
                HeapNode b = h[parent];
                h[child] = b;
                h[parent] = a;
                child = parent;
                parent = (parent-1)/2;
            }else break;
        }
    }

    public void heapifyDown() {
        int parent = 0;
        while(2*parent+1<loca) {
            int child = 2*parent+1;
            if(child+1<loca) child = h[child].key>h[child+1].key ? child : child+1;
            if(h[child].key>h[parent].key) {
                HeapNode a = h[child];
                HeapNode b = h[parent];
                h[child] = b;
                h[parent] = a;
                parent = child;
            }else break;
        }
    }

    public HeapNode extractMin() {
        //System.out.println(loca);
        HeapNode ans = h[0];
        h[0] = h[loca-1];
        loca--;
        heapifyDown();
        return ans;
    }
}
class HeapNode{
    public int key;
    public int value;
    public HeapNode(int k, int v) {
        key = k;
        value = v;
    }
}