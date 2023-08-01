import React, { useState } from 'react'
import DogDetail from './DogDetail'
import Row from 'react-bootstrap/Row'
import { getAllDogs } from '../services/dog-service'
import { useEffect } from 'react'
import axios from 'axios'

const AllDogs = () => {

    const [dogs,setDogs] = useState([]);
    // useEffect(()=>{
    //     getDogsFromAPI();}, 
    //     [dogs]
    // );
    // const getDogsFromAPI = ()=>{  getAllDogs()
    // .then(res => {
    //     setDogs(res.data);
    // })
    // .catch(err => {
    //     setDogs([]);
    //     console.log(err);
    // })}
    // useEffect(() => {
    //     const getData = async () => {
    //         let response = await fetch('http://localhost:8080/dogs');
    //         const data = await response.json();

    //         console.log(data)
            
    //     }
    //     getData();
    // })
    useEffect(() => {
        getAllDogs()
              .then(({data}) => {
              setDogs(data);
              });
      }, []);
    const countDogs = dogs.length
  
return (
    <>
    <p>All Dogs: {countDogs}</p>
    <Row >
        {dogs.map(dog=>(
            <div className='container' key={dog.dog_id}>
                
                <DogDetail info={dog} />
            </div>
        ))}
    </Row>
    </>
 )
}

export default AllDogs