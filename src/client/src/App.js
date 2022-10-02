import React from "react";
// import logo from "./logo.svg";
import "./App.css";
import $ from "jquery";

class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: [],
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/allRecipes")
      .then((res) => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            recipes: result,
          });
          // console.log(result);
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          this.setState({
            isLoaded: true,
            error,
          });
        }
      );
  }

  render() {
    const { error, isLoaded, recipes } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
      return <div>Loading...</div>;
    } else {
      return (
        <ul>
          <form>
            <label>
              Name:
              <input type="text" name="name" />
            </label>
            <input type="submit" value="Submit" />
          </form>
          {recipes.map((recipe) => (
            <li key={recipe.id}>
              {recipe.title} {recipe.culture} {recipe.temperature}
            </li>
          ))}
        </ul>
      );
    }
  }
}

export default MyComponent;

// export default class RecipeList extends React.Component {
//   constructor(props) {
//     super(props);

//     this.state = { recipe: [] };
//   }

//   componentDidMount() {
//     this.RecipeList();
//   }

//   RecipeList() {
//     $.getJSON("http://localhost:8080/api/allRecipes").then(({ results }) =>
//       this.setState({ recipe: results })
//     );
//   }

//   render() {
//     const recipes = this.state.recipe.map((item, i) => (
//       <div>
//         <h1>{item.title}</h1>
//         {/* <span>{ item.cell }, { item.email }</span> */}
//       </div>
//     ));

//     return (
//       <div id="layout-content" className="layout-content-wrapper">
//         <div className="panel-list">{recipes}</div>
//       </div>
//     );
//   }
// }
