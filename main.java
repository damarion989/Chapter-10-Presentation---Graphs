#include <stdio.h>

void merge(int numbers[], int left, int middle, int right) {
    int temp[20];
    int i = left;
    int j = middle + 1;
    int k = 0;

    while (i <= middle && j <= right) {
        if (numbers[i] < numbers[j]) {
            temp[k++] = numbers[i++];
        } else {
            temp[k++] = numbers[j++];
        }
    }

    while (i <= middle) {
        temp[k++] = numbers[i++];
    }

    while (j <= right) {
        temp[k++] = numbers[j++];
    }

    for (i = left, k = 0; i <= right; i++, k++) {
        numbers[i] = temp[k];
    }
}

void mergeSort(int numbers[], int left, int right) {
    if (left < right) {
        int middle = (left + right) / 2;

        mergeSort(numbers, left, middle);
        mergeSort(numbers, middle + 1, right);
        merge(numbers, left, middle, right);
    }
}

int main() {
    int numbers[] = {8, 3, 6, 2, 7, 1};
    int size = 6;

    printf("Before sorting: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", numbers[i]);
    }

    mergeSort(numbers, 0, size - 1);

    printf("\nAfter sorting:  ");
    for (int i = 0; i < size; i++) {
        printf("%d ", numbers[i]);
    }

    printf("\n");
    return 0;
}

    return 0;
}
