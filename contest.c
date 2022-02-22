#include <stdio.h>
#include <stdlib.h>

void MaxMin(int** pMax, int* ar, int size) {

    int* m = 0;

    m = ar;

    for (int i = 0; i < size; i++) {
        if (*m < ar[i]) m = &ar[i];
        *pMax = m;
    }
}

    int main() {

        // 3-1 배열을 이용한 최대값 출력
        int array[7];
        int max1 = 0;

        //사용자가 입력한 정수를 arr에 저장
        for (int i = 0; i < 7; i++) {
            printf("array[%d] = ", i);
            scanf_s("%d", &array[i]);

            if (array[i] > max1) max1 = array[i];


        }

        printf("배열로 호출\t : Max = %d \n", max1);

        int* max2 = 0;

        MaxMin(&max2, array, sizeof(array) / sizeof(int));

        printf("배열포인터 호출\t : Max %d \n", *max2);

        return 0;
    }