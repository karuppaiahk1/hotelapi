import * as React from 'react';
/*import React, {useEffect, useState} from 'react';*/
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, containerClasses, Paper, Button} from '@mui/material';
import { Hotel } from '@mui/icons-material';
import { Delete } from '@mui/icons-material';

export default function Hotellist() {
    const paperStyle={padding:'50px 20px', width: 600, margin:'20px auto'}
    const [name,setName]=React.useState('')
    const [location,setlocation]=React.useState('')
    const[hotel,setHotel]=React.useState([])

    const handleClick=(e)=>{e.preventDefault()
    const Hotel={name,location}
    console.log(Hotel)
    fetch("http://localhost:8080/hotel/add",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(Hotel)
  
    }).then(()=>{
      console.log("New Hotel list add")
    })
}

React.useEffect(()=>{
    fetch("http://localhost:8080/hotel/getAll")
    .then(res=>res.json())
    .then((result)=>{
      setHotel(result); 
    }
  )
  },[])
  const deleteFun=(id)=>{
    fetch("http://localhost:8080/hotel/hoteldelete/"+id,{
        method:"DELETE",headers:{"Content-Type":"application/json"}
    
})
    .then(res=>res.text())
    .then(res=>console.log(res))
}

  

  return (
      <Container>
          <Paper elevation={3} style={paperStyle}>
              <h1 style={{ color:'#4f7964'}}>Hotel's</h1>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1,},
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="hotel name"  variant="outlined" value={name} onChange={(e)=>setName(e.target.value)}/>
      <TextField  id="outlined-basic" label="hotel location" variant="outlined" value={location} onChange={(e)=>setlocation(e.target.value)} />
     
     
    </Box>
    <Button variant="contained" color='secondary' onClick={handleClick}> Add</Button>
    
    </Paper>

    <h1>Hotel list</h1>

    <Paper elevation={3} style={paperStyle}>

    {hotel.map(hotel=>(
    <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={hotel.id}>
     Id:{hotel.id}<br/>
     Name:{hotel.name}<br/>
     location:{hotel.location}
     <p align="right">
         <Button variant="outlined" startIcon={<Delete></Delete>} onClick={()=>deleteFun(hotel.id)} >
        Delete
    </Button></p>

    </Paper>
    
  ))
}
</Paper>
    </Container>   
  );
}
