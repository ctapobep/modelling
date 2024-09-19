export default class Vector {
    /** @type {number[]} */
    #components = [];

    /**
     * @param {number[]} entries
     */
    constructor(entries) {
        if(!Array.isArray(entries))
            throw new Error("Expected an array, but got: " + entries);
        if(entries.length === 0)
            throw new Error("The array must contain at least one element");
        this.#components = entries;
    }

    /**
     * @param {Vector} that
     * @returns {number}
     */
    dot(that) {
        this.#assertDimsCompatible(that);
        let result = 0;
        for (let i = 0; i < this.#components.length; i++)
            result += this.at(i) * that.at(i);
        return result;
    }

    /**
     * @returns {number}
     */
    norm() {
        return Math.sqrt(this.dot(this));
    }

    at(idx) {
        return this.#components[idx];
    }
    get dims() {
        return this.#components.length;
    }

    /** @param {Vector} that */
    #assertDimsCompatible(that) {
        if(!(that instanceof Vector))
            throw new Error("The object isn't a Vector: " + that);
        if(this.dims !== that.dims)
            throw new Error(`Vector dimensions aren't compatible: ${this.dims} != ${that.dims}`);
    }
}