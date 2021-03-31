const createQuery = (leftOperand, rightOperand, operator) => {
  let url = `http://localhost:8080/leftOperand=${leftOperand}&rightOperand=${rightOperand}&operation=${operator}`;
  return url;
}
