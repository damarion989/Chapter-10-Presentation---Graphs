#include <stdio.h>

#define SIZE 5

typedef struct {
    int edges[SIZE][SIZE];
} Graph;

char names[SIZE] = {'A', 'B', 'C', 'D', 'E'};

void addEdge(Graph *graph, int from, int to) {
    graph->edges[from][to] = 1;
    graph->edges[to][from] = 1;
}

void printPath(int parent[], int vertex) {
    if (parent[vertex] != -1) {
        printPath(parent, parent[vertex]);
        printf(" -> ");
    }
    printf("%c", names[vertex]);
}

int depthFirstSearch(Graph *graph, int current, int target,
                     int visited[], int parent[]) {
    visited[current] = 1;

    if (current == target) {
        return 1;
    }

    for (int next = 0; next < SIZE; next++) {
        if (graph->edges[current][next] && !visited[next]) {
            parent[next] = current;

            if (depthFirstSearch(graph, next, target, visited, parent)) {
                return 1;
            }
        }
    }

    return 0;
}

int breadthFirstSearch(Graph *graph, int start, int target, int parent[]) {
    int visited[SIZE] = {0};
    int queue[SIZE];
    int front = 0;
    int back = 0;

    visited[start] = 1;
    queue[back++] = start;

    while (front < back) {
        int current = queue[front++];

        if (current == target) {
            return 1;
        }

        for (int next = 0; next < SIZE; next++) {
            if (graph->edges[current][next] && !visited[next]) {
                visited[next] = 1;
                parent[next] = current;
                queue[back++] = next;
            }
        }
    }

    return 0;
}

int main() {
    Graph graph = {0};

    addEdge(&graph, 0, 1); // A-B
    addEdge(&graph, 0, 2); // A-C
    addEdge(&graph, 1, 3); // B-D
    addEdge(&graph, 2, 4); // C-E
    addEdge(&graph, 3, 4); // D-E

    int dfsVisited[SIZE] = {0};
    int dfsParent[SIZE] = {-1, -1, -1, -1, -1};
    int bfsParent[SIZE] = {-1, -1, -1, -1, -1};

    printf("DFS path from A to E: ");
    if (depthFirstSearch(&graph, 0, 4, dfsVisited, dfsParent)) {
        printPath(dfsParent, 4);
    }
    printf("\n");

    printf("BFS path from A to E: ");
    if (breadthFirstSearch(&graph, 0, 4, bfsParent)) {
        printPath(bfsParent, 4);
    }
    printf("\n");

    return 0;
}
