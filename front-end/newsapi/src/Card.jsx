import React from "react";
import './App.css'

export default function ({ author, title, url, publishedAt, source }) {
    return (
        <React.Fragment>
            <div id="boxcard">
                <h2>{source}</h2>
                <h3>{title}</h3>
                <h6>{author}</h6>
                <h6>{publishedAt}</h6>
                <button>
                    <a href={url}>Ler mais</a>
                </button>
            </div>
        </React.Fragment>
    );
}