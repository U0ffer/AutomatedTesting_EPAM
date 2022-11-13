async function asyncFilter(array, predicate) {
  const results = await Promise.all(array.map(predicate));

  return array.filter((_v, index) => results[index]);
}

module.exports = {
  asyncFilter,
}
