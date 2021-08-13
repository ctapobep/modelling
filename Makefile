prd_src_dir=src/main/c
tst_src_dir=src/test/c
target_dir=target

run-tests: tests
	$(target_dir)/tests
tests: tests.o assert.o
	cc -o $(target_dir)/tests $(target_dir)/tests.o $(target_dir)/assert.o
tests.o: $(tst_src_dir)/vector_test.c $(prd_src_dir)/dims.h $(tst_src_dir)/assert.h
	cc -c $(tst_src_dir)/vector_test.c -o $(target_dir)/tests.o -include $(tst_src_dir)/assert.h -include $(prd_src_dir)/dims.h
assert.o: $(tst_src_dir)/assert.c
	cc -c $(tst_src_dir)/assert.c -o $(target_dir)/assert.o
clean:
	rm $(target_dir)/*.o
	rm $(target_dir)/tests
#la: $(prd_src_dir)/dims.h
#	cc -c $(prd_src_dir)/dims.h -o $(target_dir)/dims.o