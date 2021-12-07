import React, { useState, useEffect } from 'react';

function QueryList() {
    
    const [question, setQuestion] = useState([]);
    const url = 'http://localhost:8080/api/queries';


    const fetchQuestions = () => {
      fetch('http://localhost:8080/api/queries')
      .then(response => response.json())
      .then(data => setQuestion(data._embedded.queries))
      .catch(err => console.error(err))
  }

    useEffect(() => {
      fetchQuestions();
   }, []);
  

    return(
        <div>
       { question.map((query) =>
       <tr key={query}>
         <td>{query.question}</td>
       </tr>
       )}
        </div>
    );
}

export default QueryList;