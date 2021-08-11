import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import IconButton from "@material-ui/core/IconButton";
import Button from "@material-ui/core/Button";
import MenuIcon from "@material-ui/icons/Menu";
import ModalDialog from "@material-ui/core/Modal";
import Contact from "./Contact";
import { Link } from "react-router-dom";

const useStyles = makeStyles((theme) => ({
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

const Navbar = () => {
  const classes = useStyles();
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <AppBar style={{ background: "#2E3B55" }} position="static">
      <Toolbar>
        <IconButton
          edge="start"
          color="inherit"
          aria-label="menu"
          className={classes.menuButton}
        >
          <MenuIcon />
        </IconButton>

        <Typography color="inherit" variant="h6" className={classes.title}>
          <Link to="/">SpyGlass</Link>
        </Typography>

        <Button color="inherit" onClick={handleOpen}>
          <Link to="/Goalview">Goals Dashboard</Link>
        </Button>

        <Button color="inherit" onClick={handleOpen}>
          Who We Are
        </Button>
        <Button color="link" variant="body2">
          <Link to="/Contact">Contact</Link>
        </Button>

        <Button color="inherit" onClick={handleOpen}>
          login
        </Button>
        <text>|</text>
        <Button color="inherit" onClick={handleOpen}>
          get started
        </Button>
      </Toolbar>
      <ModalDialog open={open} handleClose={handleClose} />
    </AppBar>
  );
};

export default Navbar;
