// This is a JavaScript coding problem from BFE.dev \
// https://bigfrontend.dev/problem/implement-curry

/**
 * @param { (...args: any[]) => any } fn
 * @returns { (...args: any[]) => any }
 */
function curry(fn) {
  // your code here
  const arity = fn.length;
  return function recipe(...args) {
    if(args.length >= arity) {
        return fn.apply(this, args);
    }
    return function(...moreArgs) {
        return recipe(...args, ...moreArgs);
    }
  }
}
