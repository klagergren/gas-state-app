import './App.css';
import Header from './components/Header'
import Button from '@material-ui/core/Button'
import Select from '@material-ui/core/Select'
import GasStateInput from './components/GasStateInput';

function App() {
  return (
    <div className="container">
      <Header></Header>
      <GasStateInput></GasStateInput>
      <GasStateInput></GasStateInput>
      <Button 
        variant="contained" 
        color="primary"
        style={{
          // fontSize: 24
        }}
        onClick={() => alert("Hello")}>
        Calculate
      </Button>
    </div>
  );
}


export default App;
