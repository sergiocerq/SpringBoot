import { useState, useEffect } from 'react'
import './App.css'
import axios from 'axios';
import Card from './Card.jsx';

function App() {
  const [country, setCountry] = useState('br');
  const [data, setData] = useState([]);
  const [isloading, setIsLoading] = useState(false);
  
  useEffect(() => {
    setIsLoading(true);
    axios.get(
      `https://newsapi.org/v2/top-headlines?country=${country}&apiKey=f08f6cb38de54553a8b888ca2cf71535`
    )
    .then((response) => {
      setData(response.data.articles);
      setIsLoading(false);
    })
    .catch((error) => {
      console.error(error);
      setIsLoading(false); 
    });
  }, [country]);
  return (
    <>
    <div>
      <header>
        <em>
          News Api - Sua notícia diária
        </em>
      </header>
      <div id="buttonsflag">
        <label htmlFor="">Selecione um país ao lado: </label>
        <button onClick={() => setCountry('br')}>
          <img 
            className='photo'
            src='https://images.emojiterra.com/twitter/v14.0/512px/1f1e7-1f1f7.png'
            width={42}
            height={35}
          />
        </button>
        <button onClick={() => setCountry('gb')}>
          <img
            className='photo'
            src='https://images.emojiterra.com/twitter/v14.0/512px/1f3f4-e0067-e0062-e0065-e006e-e0067-e007f.png'
            width={42}
            height={35}
          />
        </button>
      </div>
      {
        isloading ?
          <div id='lastnotices'>
            Carregando... 
            <div id='spinner'></div>
          </div>
        :
        <div>
        <br />
        <h2 className='lastnotices'>Últimas notícias</h2>
        {
          data && data.map((articles) => {
            return <Card 
              author={articles.author}
              title={articles.title}
              url={articles.url}
              publishedAt={articles.publishedAt}
              source={articles.source.name}
            />
          })
        }
      </div>
      }
    </div>
    </>
  );
}
export default App;