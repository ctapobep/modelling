typedef struct Dims {
    int cols;
    int rows;
} Dims;
Dims create_dims(int cols, int rows) {
    Dims result;
    result.cols = cols;
    result.rows = rows;
    return result;
}