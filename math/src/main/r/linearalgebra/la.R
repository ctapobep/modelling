dot = function(v1, v2) {
  return(sum(v1 * v2));
}
vector = function(dims) {
  return(runif(dims, -1000, 1000));
}
unitVector = function(dims) {
  v = vector(dims);
  v = v / norm(v, '2');
  return(v);
}

u = unitVector(2);
sum = 0;
size = 3000;
for(i in 1:size)
  sum = sum + abs(dot(u, unitVector(2)));
sum / size
rm(list = ls())