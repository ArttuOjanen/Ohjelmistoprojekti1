import React, { useState, useEffect } from 'react';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Snackbar from '@mui/material/Snackbar';

function QueryList() {
    
    const [questions, setQuestions] = useState([]);
    const [radio, setRadio] = useState('');
    const [name, setName] = useState('');
    const [viesti, setViesti] = useState('');
    const [open, setOpen] = React.useState(false);

    const axios = require('axios');

    const fetchQuestions = () => {
      fetch('http://localhost:8080/api/queries')
      .then(response => response.json())
      .then(data => setQuestions(data._embedded.queries))
      .catch(err => console.error(err))
    }
  
    useEffect(() => {
      fetchQuestions();
   }, []);

   const handleClose = () => {
    setOpen(false);
};
    

const lisaa = (e) => {
    
  e.preventDefault();
  const formData = {
      'name': document.getElementById('name').value,
     // 'radio': document.getElementById('radio').value
  }

  axios.post('http://localhost:8080/api/answers', formData)
      .then(response => {
          if (response.status === 200) {
              setName('');
             // setRadio('');
              setViesti('Vastaukset lähetetty');
          } else {
              setViesti('Vastauksia ei lähetetty');
          }
      })
  }

   const handleChange = (e) => {
     setName( e.target.value);
   }
  
    return(
          <div className="form">
        <form method = 'post'>
          <h1>Kysely</h1>
           
          <label htmlFor='nimi'>Nimi </label> <br />
            <TextField type='text' id ='name' value={name} name='name' onChange={handleChange} /><br /><br />

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
        <div className="button">
        <Button type='submit' variant="contained" onClick={(e) => lisaa(e)}>Lähetä </Button>
        </div>
      </form>
      <p style= {{color:'red', fontSize:'24px'}}>{ viesti }</p> 
        </div>
    );
}

export default QueryList;