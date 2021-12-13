import React, { useState, useEffect } from 'react';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

function QueryList() {
    
    const [questions, setQuestions] = useState([]);
    const [answer, setAnswer] = useState({
      name: '',
      radio: ''
    });
    //const [name, setName] = useState('');
    const [viesti, setViesti] = useState('');

    //const axios = require('axios');

    const fetchQuestions = () => {
      fetch('http://localhost:8080/api/queries')
      .then(response => response.json())
      .then(data => setQuestions(data._embedded.queries))
      .catch(err => console.error(err))
    }
  
    useEffect(() => {
      fetchQuestions();
   }, []);

   const handleSave = () => {
     sendAnswers(answer);
   }

    

    const sendAnswers = newAnswer => {
      fetch('http://localhost:8080/api/answers',
      {
          method: 'POST',
          headers: {'Content-type':'application/json'},
          body: JSON.stringify(newAnswer)
      }
      )
      .then(response => response.json())
      .then(data => setAnswer(data))
      .then(_ => fetchQuestions())
      .catch(err => console.error(err))
  }

   const handleChange = (e) => {
     setAnswer({...answer, [e.target.name]: e.target.value});
   }
  
    return(
        <div>
        <form method = 'post'>
          <label>{questions.map((q) => (
            <tr key={q}>
              <td>{q.questions}</td>
            </tr>
          ))}</label>
          <label htmlFor='nimi'>Nimi </label> <br />
            <TextField type='text' id ='name' value={answer.name} name='name' onChange={handleChange} /><br /><br />

        <FormControl component="fieldset">
          <FormLabel component="legend">Radiokysymys</FormLabel>
          <RadioGroup
           aria-label="radio"
           defaultValue="yes"
           name="radio-buttons-group"
          >
        <FormControlLabel value="yes" id="yes" name="yes" control={<Radio />} label="Kyllä" />
        <FormControlLabel value="no" id="no" name="no" control={<Radio />} label="Ei" />
          </RadioGroup>
        </FormControl>
        <Button type='submit' variant="contained" onClick={handleSave}>Lisää </Button>
      </form>
      <p style= {{color:'red', fontSize:'24px'}}>{ viesti }</p>
        </div>
    );
}

export default QueryList;