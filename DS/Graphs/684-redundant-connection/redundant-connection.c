/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
typedef struct {
    int *parent;
    int *rank;
    int size;
} AdjointSet;

int init(AdjointSet *set, int edges){
    set->size = edges+1;
    set->parent = malloc(set->size * sizeof *set->parent);
    set->rank = malloc(set->size * sizeof *set->rank);

    for (int i = 0; i <= edges; i++) {
        set->parent[i] = i;
        set->rank[i] = 0;
    }
    return 1;
}

int findParent(AdjointSet *set, int x){
    if(set->parent[x]!=x){
        set->parent[x] = findParent(set, set->parent[x]);
    }

    return set->parent[x];
}

int UnionFind(AdjointSet *set, int x, int y){
    int rootX = findParent(set, x);
    int rootY = findParent(set, y);

    if(rootX==rootY){
        return 0;
    }

    if(set->rank[rootX]<set->rank[rootY]){
        set->parent[rootX] = rootY;
    } else if(set->rank[rootX]>set->rank[rootY]){
        set->parent[rootY] = rootX;
    } else{
        set->parent[rootX] = rootY;
        set->rank[rootY]++;
    }

    return 1;
}

void freeAdjointSet(AdjointSet *set) {
    free(set->parent);
    free(set->rank);
}

int* findRedundantConnection(int** edges, int edgesSize, int* edgesColSize, int* returnSize) {
    AdjointSet set;

    init(&set, edgesSize);
    int *res = malloc(2*sizeof(int));

    for(int i=0; i<edgesSize; i++){
        int u = edges[i][0];
        int v = edges[i][1];

        if(findParent(&set, u)==findParent(&set, v)){
            res[0]= u;
            res[1]=v;
            *returnSize =2;
            return res;
        }else{
            UnionFind(&set, u, v);
        }
    }

    *returnSize =0;
    return res;
}