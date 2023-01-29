#include "stdio.h"
#include "stdlib.h"
#include <execinfo.h>
#include "colors.h"
#include "assert.h"

int main() {
    Dims dimensions;
    dimensions.cols = 1;
    assertEquals(1, dimensions.cols);
    printf(GREEN "All tests passed!\n" RESET);
}