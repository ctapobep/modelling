import Vector from "../../../main/js/la/Vector.js";
import {eq} from "../util/Assert.js";

describe("Vector", () => {
    describe("dot", () => {
        it("never negative when dotting vector with itself", () => {
            let v = new Vector([1, 2]);
            eq(v.dot(v), 5);
            v = new Vector([-1, 2]);
            eq(v.dot(v), 5);
            v = new Vector([-1, -2]);
            eq(v.dot(v), 5);
        });
        it("is 0 if all the components are 0", () => {
            eq(new Vector([0, 0]).dot(new Vector([1, 2])), 0);
            eq(new Vector([1, 2]).dot(new Vector([0, 0])), 0);
        });
        it("multiples all the components and sums it", () => {
            eq(new Vector([1, -2, -1]).dot(new Vector([1, 2, 3])), -6);
        });
    })
    describe("norm", () => {
        it("is the same is dotting with itself and taking a root", ()=> {
            let v = new Vector([-1]);
            eq(v.norm(), 1);
            v = new Vector([-1, 3, 5]);
            eq(v.norm(), Math.sqrt(1+9+25));
        })
    })
})