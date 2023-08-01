import http from './axios-common';
import axios from 'axios';

export function getAllDogs(){
    const pets = axios.get(`http://localhost:8080/dogs`);
    return pets;
}