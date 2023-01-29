#include "stdio.h"
#include "stdlib.h"
#include <execinfo.h>
#include "colors.h"

void fail(char *msg) {
    printf(RED);
    printf("%s", msg);
    printf(RESET);
    printf("\n");
    void *callstack[128];
    int i, frames = backtrace(callstack, 128);
    char **strs = backtrace_symbols(callstack, frames);
    for (i = 0; i < frames; ++i)
        printf("%s\n", strs[i]);
    free(strs);
    exit(1);
}
void assertEquals(int expected, int actual) {
    if(expected == actual)
        return;
    char[100] buf;
    const char* = "Expected: %d, actual: %d";

    if (asprintf(&expected, "%d", n1) == -1) {
        perror("asprintf");
    } else {
        strcat(strcpy(buffer, str1), expected);
        printf("%s\n", buffer);
        free(num);
    }

    fail(sprintf(buf, 12, , expected, actual));
}