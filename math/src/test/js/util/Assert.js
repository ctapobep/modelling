import assert from 'assert';

/**
 * @param {any} actual
 * @param {any} expected
 * @param {string|null} errorMsg
 */
export function eq(actual, expected, errorMsg = null) {
    assert.strictEqual(actual, expected, errorMsg);
}

/**
 * @param {Vector} actual
 * @param {Vector} expected
 */
export function eqVector(actual, expected) {
    eq(actual.dims, expected.dims, `Vectors are of different lengths: ${actual.dims} !== ${expected.dims}`);
    for (let i = 0; i < actual.dims.length; i++)
        eq(actual.at(i), expected.at(i),
            `Vector components were different at ${i}, ${actual.at(i)} !== ${expected.at(i)}:\n`
                ` Expected: ${expected}\n Actual:   ${actual}`);
}