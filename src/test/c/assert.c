#include "stdio.h"
#include "stdlib.h"
#include <execinfo.h>
#include "colors.h"

void fail(char *msg) {
    printf(RED);
    printf("%s", msg);
    printf(RESET);
    void *callstack[128];
    int i, frames = backtrace(callstack, 128);
    char **strs = backtrace_symbols(callstack, frames);
    for (i = 0; i < frames; ++i) {
        printf("%s\n", strs[i]);
    }
    free(strs);
    exit(1);
}
void assertEquals(int expected, int actual) {
    if(expected != actual)
        fail("Different values!\n");
}