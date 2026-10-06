document.addEventListener('pointermove',e=>{
  const r=document.documentElement.style;
  r.setProperty('--px',((e.clientX/innerWidth)-.5)*-18);
  r.setProperty('--py',((e.clientY/innerHeight)-.5)*-8);
});