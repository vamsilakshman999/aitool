const { sum } = require('./app');

test('adds numbers', () => {
  expect(sum(1, 2)).toBe(3);
});
